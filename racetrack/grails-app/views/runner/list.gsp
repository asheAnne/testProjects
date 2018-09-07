
<%@ page import="racetrack.Runner" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'runner.label', default: 'Runner')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'runner.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="firstName" title="${message(code: 'runner.firstName.label', default: 'First Name')}" />
                        
                            <g:sortableColumn property="lastName" title="${message(code: 'runner.lastName.label', default: 'Last Name')}" />
                        
                            <g:sortableColumn property="dateOfBirth" title="${message(code: 'runner.dateOfBirth.label', default: 'Date Of Birth')}" />
                        
                            <g:sortableColumn property="gender" title="${message(code: 'runner.gender.label', default: 'Gender')}" />
                        
                            <g:sortableColumn property="address" title="${message(code: 'runner.address.label', default: 'Address')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${runnerInstanceList}" status="i" var="runnerInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${runnerInstance.id}">${fieldValue(bean: runnerInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: runnerInstance, field: "firstName")}</td>
                        
                            <td>${fieldValue(bean: runnerInstance, field: "lastName")}</td>
                        
                            <td><g:formatDate date="${runnerInstance.dateOfBirth}" /></td>
                        
                            <td>${fieldValue(bean: runnerInstance, field: "gender")}</td>
                        
                            <td>${fieldValue(bean: runnerInstance, field: "address")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${runnerInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
