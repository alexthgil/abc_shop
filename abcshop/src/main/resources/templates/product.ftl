<#include "parts/security.ftl">
<#import "parts/common.ftl" as c>
<#import "parts/syslogin.ftl" as l>

<@c.page>

  <#if isAdmin>
      <div>
        <form method="post" enctype="multipart/form-data">
          <input type="hidden" name="_csrf" value="${_csrf.token}" />
          <input type="text" name="name" placeholder="product name" />
          <input type="text" name="description" placeholder="description" />
          <input type="file" name="file" />
          <button type="submit">Add</button>
        </form>
      </div>
  </#if>

    <div>Products list</div>

    <#list products?chunk(3) as row>
      <div class="row m-3">
        <#list row as product>
          <div class="col-lg-4">

            <div class="card h-100">
              <#if product.filename??>
                <img class="card-img-top" src="/img/${product.filename}">
              </#if>
              <b>${product.id}</b>
              <span>${product.name}</span>
              <div class="h-25 d-inline-block">
                <i>${product.description}</i>
              </div>

              <div class="card-body">
                <a href="/basket/${product.id}" class="card-link">Add to basket</a>
              </div>
            </div>
          </div>
        </#list>
      </div>
      <#else>
        <div class="something">No products</div>
    </#list>

</@c.page>