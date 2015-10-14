<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="my.app.switcher.Test" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Stack" %>
<html>
<head>
    <title></title>
    <link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
<form action="start" method="get">
    <%
        Test test = new Test();
        String expression = request.getParameter("expression");
        String result = request.getParameter("result");


        if (expression == null) {
            expression = "";
        }
        if (result == null) {
            result = "";
        }
    %>

    <center><h1>Calc</h1></center>
    <table class="table">
        <tr>
            <td>
               <button class="button btn-success" name="decToBinIn" value="decBin">decimalBinary</button>
            </td>
            <td>
               <button class="button btn-success" name="decToBinOut" value="decBin">decimalBinary</button>
            </td>
        </tr>
        <tr>
            <td>
                <button class="button btn-success" name="decToHexIn" value="decHex">decimalHex</button>
            </td>
            <td>
                <button class="button btn-success" name="decToHexOut" value="decHex">decimalHex</button>
            </td>
        </tr>
        <tr>
            <td>
                <button class="button btn-warning" name="binToDecIn" value="binDec">binaryDecimal</button>
            </td>
            <td>
                <button class="button btn-warning" name="binToDecOut" value="binDec">binaryDecimal</button>
            </td>
        </tr>
        <tr>
            <td>
                <button class="button btn-warning" name="binToHexIn" value="binHex">binaryHex</button>
            </td>
            <td>
                <button class="button btn-warning" name="binToHexOut" value="binHex">binaryHex</button>
            </td>
        </tr>
        <tr>
            <td>
                <button class="button btn-danger" name="hexToDecIn" value="hexDec">hexDecimal</button>
            </td>
            <td>
                <button class="button btn-danger" name="hexToDecOut" value="hexDec">hexDecimal</button>
            </td>
        </tr>
        <tr>
            <td>
                <button class="button btn-danger" name="hexToBinIn" value="hexBin">hexBinary</button>
            </td>
            <td>
                <button class="button btn-danger" name="hexToBinOut" value="hexBin">hexBinary</button>
            </td>
        </tr>
        <tr>
            <td>Expression <input type="text" class="form-control" name="expression" value="<%=expression%>"/></td>
            <td>Result <input type="text" class="form-control" name="result" value="<%=result%>"/></td>
        </tr>
        <tr>
            <td>
                <button class="btn btn-success" name="enter" value="eval">
                    Eval
                </button>
                <button class="btn btn-success" name="enter" value="load">
                    Load File
                </button>
                <button class="btn btn-success" name="enter" value="save">
                    Save File
                </button>
                <button class="btn btn-success" name="enter" value="insert">
                    Database
                </button>
            </td>
        </tr>
    </table>

</form>

</body>
</html>
