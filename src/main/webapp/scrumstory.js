(function () {
    function loadScript(url) {

        var script = document.createElement("script")
        script.type = "text/javascript";
        script.src = url;
        document.body.appendChild(script);
    }
alert("load");

    loadScript("apps.js");
    loadScript("project/projects.js");
    loadScript("project/projectController.js");
    loadScript("project/projectService.js");

})();
