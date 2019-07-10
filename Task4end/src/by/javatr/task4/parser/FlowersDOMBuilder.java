package by.javatr.task4.parser;

import by.javatr.task4.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class FlowersDOMBuilder extends AbstractFlowersBuilder {
    private DocumentBuilder docBuilder;

    public FlowersDOMBuilder() {
        this.flowers = new HashSet<Flower>();
        // создание DOM-анализатора
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public FlowersDOMBuilder(Set<Flower> flowers) {
        super(flowers);
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    @Override
    public void buildSetFlowers(String fileName) {
        Document doc = null;
        try {
            // parsing XML-документа и создание древовидной структуры
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            // получение списка дочерних элементов <flower>
            NodeList flowersList = root.getElementsByTagName("flower");
            for (int i = 0; i < flowersList.getLength(); i++) {
                Element flowerElement = (Element) flowersList.item(i);
                Flower flower = buildFlower(flowerElement);
                flowers.add(flower);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    private Flower buildFlower(Element flowerElement) {
        Flower flower = new Flower();
        // заполнение объекта flower
        flower.setId(flowerElement.getAttribute("id"));//FlowerEnum.ID.toString().toLowerCase())
        flower.setSoil(SoilType.fromValue(flowerElement.getAttribute("soil")));
        flower.setMultiplying(MultiplyingType.fromValue(flowerElement.getAttribute("multiplying")));
        flower.setName(getElementTextContent(flowerElement, "name"));
        flower.setOrigin(getElementTextContent(flowerElement, "origin"));
        VisualParam visualParam = flower.getVisualParam();
        Element vpElement = (Element) flowerElement.getElementsByTagName("visual_param").item(0);
        visualParam.setStalkColor(getElementTextContent(vpElement, "stalk_color"));
        visualParam.setLeafColor(getElementTextContent(vpElement, "leaf_color"));
        Integer flower_size = Integer.parseInt(getElementTextContent(vpElement, "flower_size"));
        visualParam.setFlowerSize(flower_size);

        GrowingTips growingTips = flower.getGrowingTips();
        Element gtElement = (Element) flowerElement.getElementsByTagName("growing_tips").item(0);

        Integer temperature = Integer.parseInt(getElementTextContent(gtElement, "temperature"));
        growingTips.setTemperature(temperature);
        Boolean photoph = Boolean.parseBoolean(getElementTextContent(gtElement, "photophilious"));
        growingTips.setPhotophilious(photoph);
        Integer watering = Integer.parseInt(getElementTextContent(gtElement, "watering"));
        growingTips.setWatering(watering);
        String s = getElementTextContent(flowerElement, "landing_date");
        Calendar data = Calendar.getInstance();
        String[] str = s.split("-");
        data.set(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
        flower.setLandingDate(data);

        return flower;
    }

    // получение текстового содержимого тега
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}


