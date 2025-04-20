## CWE-22

https://cwe.mitre.org/data/definitions/22.html

Приложение использует внешние входные данные для создания пути файла, но не нейтрализует должным образом
элементы в имени пути, из-за которых имя пути может указывать на расположение за пределами каталога с ограниченным
доступом.

## Найденные уязвимости:

### CompareToolUtil.removeFiles

Стек вызовов: 1

POC: [itextpdf/CompareToolUtil_1.java](../src/main/java/org/example/itextpdf/CompareToolUtil_1.java)

Метод позволяет удалить произвольный файл в системе

Sink: java.io.File.<init>

Публичный метод: com.itextpdf.testutils.CompareToolUtil.removeFiles

### CompareToolUtil.copy

Стек вызовов: 1

POC: [itextpdf/CompareToolUtil_2.java](../src/main/java/org/example/itextpdf/CompareToolUtil_2.java)

Метод позволяет перезаписать произвольный файл в системе

Sink: java.io.OutputStream.write

Публичный метод: com.itextpdf.testutils.CompareToolUtil.copy


### Utilities.readFileToString

Стек вызовов: 2

POC: [itextpdf/Utilities_1.java](../src/main/java/org/example/itextpdf/Utilities_1.java)

Метод позволяет прочитать содержимое произвольного файла в системе

Sink: java.io.FileInputStream.read

Публичный метод: com.itextpdf.text.Utilities.readFileToString

### Base64.decodeFromFile

Стек вызовов: 2

POC: [itextpdf/Base64_1.java](../src/main/java/org/example/itextpdf/Base64_1.java)

Метод позволяет прочитать содержимое в формате base64 произвольного файла в системе

Sink: java.io.FileInputStream.read (через com.itextpdf.text.pdf.codec.Base64.InputStream.read)

Публичный метод: com.itextpdf.text.pdf.codec.Base64.decodeFromFile

### TempFileCache.<init>

Стек вызовов: 1

POC: [itextpdf/TempFileCache_1.java](../src/main/java/org/example/itextpdf/TempFileCache_1.java)

Метод позволяет перезаписать произвольный файл в системе

Sink: java.io.ObjectOutputStream.writeObject

Публичный метод: com.itextpdf.text.io.TempFileCache.<init>




