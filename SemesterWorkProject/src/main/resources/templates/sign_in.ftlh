<#import 'macros/mainLayout.ftl' as layout/>
<#import 'macros/form.ftl' as form/>
<#import '/spring.ftl' as spring/>

<@layout.main title="SignIn" pathJs=''>
    <div class="parent-container">
        <div class="registration-form">
            <form action="${springMacroRequestContext.contextPath}/signIn" method="POST">
                <div class="form-name">
                    <h2>Sign In</h2>
                </div>
                <@form.input 'form.username' 'Username'/>
                <@form.password 'form.password' 'Password'/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="form-button">
                    <button type="submit" class="btn btn-block btn-outline-success btn-form">Login</button>
                </div>
            </form>
            <div class="form-button">
                <p class="text-reg">No account?&nbsp;&nbsp;<a href="${springMacroRequestContext.contextPath}/signUp">Sign Up</a></p>
            </div>
        </div>
    </div>
</@layout.main>