
<html>
 <head>
  <title>Admin Page</title>
 </head>
 <body>
  <g:render template="/layouts/header"/>
  <h1 class="admin-header">Welcome Admin!</h1>
  <style>

  </style>

  <ul>
   <g:each var="c" in="${grailsApplication.controllerClasses}" >
     <g:if test="${c.name != 'Searchable' && c.name != 'Admin'}">
      <li class="controller">
       <g:link controller="${c.logicalPropertyName}">
        ${c.name}
       </g:link>
      </li>
     </g:if>
  </g:each>
 </ul>

 </body>
</html>
