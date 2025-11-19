<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color:red;text-align: center"> Actor Edit Form Page </h1>

<frm:form modelAttribute="actor">
<table bgcolor="cyan" align="center">
 <tr>
     <td> Actor Id </td>
     <td> <frm:input type="text" path="aid"  readonly="true"/></td>
   </tr>
   <tr>
     <td> Actor Name </td>
     <td> <frm:input type="text" path="aname"/></td>
   </tr>
   <tr>
     <td> Actor Address </td>
     <td> <frm:input type="text" path="addrs"/></td>
   </tr>
   <tr>
     <td> Actor Category </td>
     <td> <frm:input type="text" path="category"/></td>
   </tr>
     <tr>
     <td> Actor Remuneration </td>
     <td> <frm:input type="text" path="remuneration"/></td>
   </tr>
      <tr>
     <td> <input type="submit"  value="Edit Actor"> </td>
     <td> <input type="reset"  value="cancel"></td>
   </tr>
</table>
</frm:form>
