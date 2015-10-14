package my.webapp.servlets;

import my.app.IO.FileOut;
import my.app.switcher.Test;

import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class StartServlet extends Dispatcher {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Test test = new Test();
        FileOut fileOut = new FileOut();
        String expression = req.getParameter("expression");
        String result = "";
            try {
                if(expression.equals("")){
                    result = "";
                } else result = fileOut.getScriptEngine().eval(expression).toString();
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        String action = req.getParameter("enter");
        String decToBinIn = req.getParameter("decToBinIn");
        String decToHexIn = req.getParameter("decToHexIn");
        String binToHexIn = req.getParameter("binToHexIn");
        String binToDecIn = req.getParameter("binToDecIn");
        String hexToBinIn = req.getParameter("hexToBinIn");
        String hexToDecIn = req.getParameter("hexToDecIn");
        String decToBinOut = req.getParameter("decToBinOut");
        String decToHexOut = req.getParameter("decToHexOut");
        String binToHexOut = req.getParameter("binToHexOut");
        String binToDecOut = req.getParameter("binToDecOut");
        String hexToBinOut = req.getParameter("hexToBinOut");
        String hexToDecOut = req.getParameter("hexToDecOut");

        if ("eval".equals(action)) {
            super.forward("/index.jsp?expression=" + expression + "&result=" + result, req, resp);
        } else if ("load".equals(action)) {
            FileOut secondFile = new FileOut(new File("e:/d.txt"));
            String sexpression = secondFile.getExpression();
            secondFile.closeReader();
            try {
                result = fileOut.getScriptEngine().eval(sexpression).toString();
            } catch (ScriptException e) {
                e.printStackTrace();
            }
            super.forward("/index.jsp?expression=" + sexpression + "&result=" + result, req, resp);
        } else if ("save".equals(action)) {
            fileOut.setExpression(result);
            fileOut.outputFile(new File("e:/data.txt"));
            super.forward("/index.jsp?expression=" + expression + "&result=" + result, req, resp);
        } else if ("insert".equals(action)) {
            fileOut.setExpression(expression);
            fileOut.outputDB();
            super.forward("/index.jsp?expression=" + expression + "&result=" + result, req, resp);
        } else if ("decBin".equals(decToBinIn)) {
            expression = test.convertDecimalBinary(expression);
            super.forward("/index.jsp?expression=" + expression, req, resp);
        } else if ("decHex".equals(decToHexIn)) {
            expression = test.convertDecimalHex(expression);
            super.forward("/index.jsp?expression=" + expression, req, resp);
        } else if ("binDec".equals(binToDecIn)) {
            expression = test.convertBinaryDecimal(expression);
            super.forward("/index.jsp?expression=" + expression, req, resp);
        } else if ("binHex".equals(binToHexIn)) {
            expression = test.convertBinaryHex(expression);
            super.forward("/index.jsp?expression=" + expression, req, resp);
        } else if ("hexDec".equals(hexToDecIn)) {
            expression = test.convertHexDecimal(expression);
            super.forward("/index.jsp?expression=" + expression, req, resp);
        } else if ("hexBin".equals(hexToBinIn)) {
            expression = test.convertHexBinary(expression);
            super.forward("/index.jsp?expression=" + expression, req, resp);
        } else if ("decBin".equals(decToBinOut)) {
            result = test.convertDecimalBinary(req.getParameter("result"));
            super.forward("/index.jsp?&result=" + result, req, resp);
        } else if ("decHex".equals(decToHexOut)) {
            result = test.convertDecimalHex(req.getParameter("result"));
            super.forward("/index.jsp?&result=" + result, req, resp);
        } else if ("binDec".equals(binToDecOut)) {
            result = test.convertBinaryDecimal(req.getParameter("result"));
            super.forward("/index.jsp?&result=" + result, req, resp);
        } else if ("binHex".equals(binToHexOut)) {
            result = test.convertBinaryHex(req.getParameter("result"));
            super.forward("/index.jsp?&result=" + result, req, resp);
        } else if ("hexDec".equals(hexToDecOut)) {
            result = test.convertHexDecimal(req.getParameter("result"));
            super.forward("/index.jsp?&result=" + result, req, resp);
        } else if ("hexBin".equals(hexToBinOut)) {
            result = test.convertHexBinary(req.getParameter("result"));
            super.forward("/index.jsp?&result=" + result, req, resp);
        }
    }

    public static void main(String[] args) {
        String expression = "2+4";
        Test test = new Test();
        expression = test.convertDecimalBinary(expression);
        System.out.println(expression);

        StartServlet s = new StartServlet();

    }
}
