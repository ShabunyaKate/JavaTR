package by.javatr.task4.parser;

import by.javatr.task4.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

    public class FlowersStAXBuilder extends AbstractFlowersBuilder {
        private static final Logger log= LogManager.getLogger(FlowersStAXBuilder.class);
        private XMLInputFactory inputFactory;

        public FlowersStAXBuilder() {
            inputFactory = XMLInputFactory.newInstance();
        }

        public FlowersStAXBuilder(Set<Flower> flowers) {
            super(flowers);
        }

        public Set<Flower> getFlowers() {
            return flowers;
        }

        @Override
        public void buildSetFlowers(String fileName) {
            FileInputStream inputStream = null;
            XMLStreamReader reader = null;
            String name;
            try {
                inputStream = new FileInputStream(new File(fileName));
                reader = inputFactory.createXMLStreamReader(inputStream);
                while (reader.hasNext()) {
                    int type = reader.next();
                    if (type == XMLStreamConstants.START_ELEMENT) {
                        name = reader.getLocalName();
                        if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.FLOWER) {
                            Flower fl = buildFlower(reader);
                            flowers.add(fl);
                        }
                    }
                }
            } catch (XMLStreamException ex) {
                log.error("StAX parsing error!");
            } catch (FileNotFoundException ex) {
                log.error("File " + fileName + " not found! " + ex);
            } finally {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    log.error("Impossible close file " + fileName + " : " + e);
                }
            }
        }

        private Flower buildFlower(XMLStreamReader reader) throws XMLStreamException {
            Flower fl = new Flower();
            fl.setId(reader.getAttributeValue(null, FlowerEnum.ID.getValue()));
            fl.setSoil(SoilType.fromValue(reader.getAttributeValue(null, FlowerEnum.SOIL.getValue())));
            fl.setMultiplying(MultiplyingType.fromValue(reader.getAttributeValue(null, FlowerEnum.MULTIPLYING.getValue())));// проверить на null
            String name;
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        switch (FlowerEnum.valueOf(name.toUpperCase())) {
                            case NAME:
                                fl.setName(getXMLText(reader));
                                break;
                            case ORIGIN:
                                fl.setOrigin(getXMLText(reader));
                                break;
                            case VISUAL_PARAM:
                                fl.setVisualParam(getXMLVisualParam(reader));
                                break;
                            case GROWING_TIPS:
                                fl.setGrowingTips(getXMLGrowingTips(reader));
                                break;
                            case LANDING_DATE:
                                name = getXMLText(reader);
                                Calendar data = Calendar.getInstance();
                                String[] str = name.split("-");
                                data.set(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
                                fl.setLandingDate(data);
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.FLOWER) {
                            return fl;
                        }
                        break;
                }
            }
            throw new XMLStreamException("Unknown element in tag Flower");
        }

        private VisualParam getXMLVisualParam(XMLStreamReader reader) throws XMLStreamException {
            VisualParam visualParam = new VisualParam();
            int type;
            String name;
            while (reader.hasNext()) {
                type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        switch (FlowerEnum.valueOf(name.toUpperCase())) {
                            case STALK_COLOR:
                                visualParam.setStalkColor(getXMLText(reader));
                                break;
                            case LEAF_COLOR:
                                visualParam.setLeafColor(getXMLText(reader));
                                break;
                            case FLOWER_SIZE:
                                name = getXMLText(reader);
                                visualParam.setFlowerSize(Integer.parseInt(name));
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.VISUAL_PARAM) {
                            return visualParam;

                        }
                        break;
                }
            }
            throw new XMLStreamException("Unknown element in tag VisualParam");
        }

        private GrowingTips getXMLGrowingTips(XMLStreamReader reader) throws XMLStreamException {
            GrowingTips growingTips = new GrowingTips();
            int type;
            String name;
            while (reader.hasNext()) {
                type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        switch (FlowerEnum.valueOf(name.toUpperCase())) {
                            case TEMPERATURE:
                                name = getXMLText(reader);
                                growingTips.setTemperature(Integer.parseInt(name));
                                break;
                            case PHOTOPHILIOUS:
                                name = getXMLText(reader);
                                growingTips.setPhotophilious(Boolean.parseBoolean(name));
                                break;
                            case WATERING:
                                name = getXMLText(reader);
                                growingTips.setWatering(Integer.parseInt(name));
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.GROWING_TIPS) {
                            return growingTips;

                        }
                        break;
                }
            }
            throw new XMLStreamException("Unknown element in tag GrowingTips");
        }

        private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
            String text = null;
            if (reader.hasNext()) {
                reader.next();
                text = reader.getText();
            }
            return text;
        }
    }