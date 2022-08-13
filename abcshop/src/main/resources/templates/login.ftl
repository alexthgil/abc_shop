<#import "parts/common.ftl" as c>
<#import "parts/syslogin.ftl" as l>

<@c.page>
    <div>Login page</div>
    <@l.login "/login"/>
    <a href="/registration">Add new user</a>
</@c.page>