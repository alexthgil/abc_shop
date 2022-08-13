<#assign 
    known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        isLogin = true
        name = user.getUsername()
        isAdmin = user.isAdmin()
    >
<#else>
    <#assign
        isLogin = false
        name = ""
        isAdmin = false
    >
</#if>