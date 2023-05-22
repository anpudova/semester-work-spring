document.getElementById('add-ing').addEventListener('click', function() {

    let container = document.getElementById('input-ingredient');
    let count = container.getElementsByClassName("form-group").length;
    let newInput = document.createElement("div");
    newInput.className = "form-group";
    newInput.innerHTML = "<label class=\"form-label\"></label><input type=\"text\" id=\"ingredients" + count + ".ingredient\" name=\"ingredients[" + count + "].ingredient\" value=\"\" class=\"form-control item\">";
    container.appendChild(newInput);
});

document.getElementById('add-step').addEventListener('click', function() {
    let container = document.getElementById('input-step');
    let count = container.getElementsByClassName("form-group").length;
    let newInput = document.createElement("div");
    newInput.className = "form-group";
    newInput.innerHTML = "<label class=\"form-label\"></label><input type=\"text\" id=\"steps" + count + ".step\" name=\"steps[" + count + "].step\" value=\"\" class=\"form-control item\">";
    container.appendChild(newInput);
});