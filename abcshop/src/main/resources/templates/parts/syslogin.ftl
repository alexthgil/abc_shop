<#macro login path>
    <form action="${path}" method="POST">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="form-group row mt-1">
            <label class="col-sm-2 col-form-label">Name:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" name="username"/> 
            </div>
        </div>
        <div class="form-group row mt-1">
            <label class="col-sm-2 col-form-label">Password:</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" name="password"/> 
            </div>
        </div>
        <button type="submit" class="btn btn-primary mt-1">Sign In</button>
    </form>
</#macro>

<#macro logout>
    <div>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-secondary mt-1">Sign Out</button>
        </form>
    </div>
</#macro>