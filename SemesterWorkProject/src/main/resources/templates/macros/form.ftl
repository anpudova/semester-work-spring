<#import '/spring.ftl' as spring/>

<#macro input path label type='text' required='' length=''>
    <@spring.bind path/>
    <div class="form-group">
        <label class="form-label">${label}</label>
        <@spring.formInput path 'class="form-control item" ${required}' type/>
        <@spring.showErrors ' ' 'form-text'/>
    </div>
</#macro>

<#macro password path label type='text' required='' length=''>
    <@spring.bind path/>
    <div class="form-group">
        <label class="form-label">${label}</label>
        <@spring.formPasswordInput path 'class="form-control item" ${required}'/>
        <@spring.showErrors ' ' 'form-text'/>
    </div>
</#macro>
