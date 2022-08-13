<#import "parts/common.ftl" as c>
<#import "parts/syslogin.ftl" as l>

<@c.page>
  <div>Basket list</div>

  <#list products?chunk(3) as row>
    <div class="row">
      <#list row as product>
        <div class="col-lg-4">
          <div class="card" style="width: 18rem;">
            <#if product.filename??>
              <img class="card-img-top" src="/img/${product.filename}">
            </#if>
            <b>${product.id}</b>
            <span>${product.name}</span>
            <i>${product.description}</i>
            <div class="card-body"></div>
          </div>
        </div>
      </#list>
    </div>
  <#else>
      <div class="something">Basket is empty</div>
  </#list>

</@c.page>