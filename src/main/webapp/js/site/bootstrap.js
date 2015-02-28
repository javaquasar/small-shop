define([
    'require',
    'angular',
    'angularRoute',
    'requireDomReady',
    'app'
], function (require, ng) {
    'use strict';

    require(['requireDomReady!'], function (document) {
        ng.bootstrap(document.getElementById("appContent"), ['app']);
    });
});