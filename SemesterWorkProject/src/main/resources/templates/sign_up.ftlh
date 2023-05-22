<#import 'macros/mainLayout.ftl' as layout/>
<#import 'macros/form.ftl' as form/>
<#import '/spring.ftl' as spring/>

<@layout.main title="SignUp" pathJs=''>
    <div class="parent-container">
        <div class="registration-form">
            <form method="post">
                <div class="form-name">
                    <h2>Sign Up</h2>
                </div>
                <@form.input 'form.username' 'Username'/>
                <@form.password 'form.password' 'Password'/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="form-button">
                    <button type="submit" class="btn btn-block btn-outline-success btn-form">Sign Up</button>
                </div>
            </form>
            <div class="form-button">
                <p class="text-reg">Already have an account?&nbsp;&nbsp;<a href="${springMacroRequestContext.contextPath}/signIn">Sign In</a></p>
            </div>
            <#if errorFields?has_content >
                <p>${errorFields}</p>
            </#if>
            <#if error?has_content >
                <p>${error}</p>
            </#if>
        </div>
    </div>
</@layout.main>
