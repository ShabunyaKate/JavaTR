package by.javatr.task4.parser;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import by.javatr.task4.entity.Flower;
import by.javatr.task4.entity.FlowerEnum;
import by.javatr.task4.entity.MultiplyingType;
import by.javatr.task4.entity.SoilType;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class FlowerHandler extends DefaultHandler {
        private Set<Flower> flowers;
        private Flower current = null;
        private FlowerEnum currentEnum = null;
        private EnumSet<FlowerEnum> withText;
        public FlowerHandler() {
            flowers = new HashSet<Flower>();
            withText = EnumSet.range(FlowerEnum.NAME, FlowerEnum.LANDING_DATE);
        }
        public Set<Flower> getFlowers() {
            return flowers;
        }
        public void startElement(String uri, String localName, String qName, Attributes attrs) {
            if ("flower".equals(localName)) {
                current = new Flower();
                current.setId(attrs.getValue(0));
                current.setSoil(SoilType.fromValue(attrs.getValue(1)));
                if (attrs.getLength() == 3) {
                    current.setMultiplying(MultiplyingType.fromValue(attrs.getValue(2)));
                }
            } else {
                FlowerEnum temp = FlowerEnum.valueOf(localName.toUpperCase());
                if (withText.contains(temp)) {
                    currentEnum = temp;
                }
            }
        }
        public void endElement(String uri, String localName, String qName) {
            if ("flower".equals(localName)) {
                flowers.add(current);
            }
        }
        public void characters(char[] ch, int start, int length) {
            String s = new String(ch, start, length).trim();
            if (currentEnum != null) {
                switch (currentEnum) {
                    case NAME:
                        current.setName(s);
                        break;
                    case ORIGIN:
                        current.setOrigin(s);
                        break;
                    case STALK_COLOR:
                        current.getVisualParam().setStalkColor(s);
                        break;
                    case LEAF_COLOR:
                        current.getVisualParam().setLeafColor(s);
                        break;
                    case FLOWER_SIZE:
                        current.getVisualParam().setFlowerSize(Integer.parseInt(s));
                        break;
                    case TEMPERATURE:
                        current.getGrowingTips().setTemperature(Integer.parseInt(s));
                        break;
                    case PHOTOPHILIOUS:
                        current.getGrowingTips().setPhotophilious(Boolean.parseBoolean(s));
                        break;
                    case WATERING:
                        current.getGrowingTips().setWatering(Integer.parseInt(s));
                        break;
                    case LANDING_DATE:
                        Calendar data=Calendar.getInstance();
                        String[] str=s.split("-");
                        data.set(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2]));
                        current.setLandingDate(data);
                        break;
                    default:
                        throw new EnumConstantNotPresentException(
                                currentEnum.getDeclaringClass(), currentEnum.name());
                }
            }
            currentEnum = null;
        }
    }

