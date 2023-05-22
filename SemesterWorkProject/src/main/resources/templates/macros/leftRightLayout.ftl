<#import 'mainLayout.ftl' as layout/>
<#import '/spring.ftl' as spring/>

<#macro entrance title pathJs>
    <@layout.main title pathJs>
        <div class="parent-main">
            <div class="left"></div>
            <div class="parent-container">
                <div class="container" style="margin: 0;">
                    <#nested>
                </div>
            </div>
            <div class="right"></div>
        </div>
    </@layout.main>
</#macro>