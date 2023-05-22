<#import 'macros/leftRightLayout.ftl' as layout/>
<#import 'macros/form.ftl' as form/>
<#import '/spring.ftl' as spring/>

<@layout.entrance title="EditProfile" pathJs=''>
    <div class="main">
        <h2>Edit profile</h2>
    </div>
    <div class="parent-profile">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-md-8">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body text-center">
                            <form method="post" action="${springMacroRequestContext.contextPath}/profile/edit">
                                <@form.input 'form.username' 'Username'/>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                <div class="form-button">
                                    <button type="submit" class="btn btn-block btn-outline-success my-btn">Save</button>
                                </div>
                            </form>
                            <#if errorFields?has_content >
                                <p>${errorFields}</p>
                            </#if>
                            <#if error?has_content >
                                <p>${error}</p>
                            </#if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@layout.entrance>