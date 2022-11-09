package edu.wallawalla.cs.cptr354.visitor;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class AbstractTests {
  ExpressionParser parser = new ExpressionParser(new StringReader(""));

  public String runInterpreter(String inputString) throws Exception {
    String result = ConsoleInterceptor.copyOut(() -> {
      parser.ReInit(new StringReader(inputString));
      ASTstart expr = parser.start();
      ExpressionVisitor v = new ExpressionVisitor();
      expr.jjtAccept(v, null);
    });
    return result;
  }

  // Read file content into string with - Files.readAllBytes(Path path)
  // Found at https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
  public static String readFileToString(String filePath) {
    String content = "";
    try {
      content = new String(Files.readAllBytes(Paths.get("src/test/resources/"+filePath)));
    } catch (IOException e) {
      e.printStackTrace();
    }

    return content;
  }
}
