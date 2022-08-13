<#include "security.ftl">
<#import "syslogin.ftl" as l>

<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">ABCShop</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/product">Products</a>
                </li>

            <#if isLogin>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/basket">Basket</a>
                </li>
            </#if>

            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/user">User list</a>
                </li>
            </#if>

            </ul>
        </div>

        <#if isLogin>
            <div class="navbar-text">${name}</div>
            <div class="ms-4">
                <@l.logout />
            </div>
            <#else>
                <a class="btn btn-primary" href="/login" role="button">Login</a>
        </#if>

    </div>
</nav>