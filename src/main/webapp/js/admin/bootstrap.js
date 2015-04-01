define([
    'require',
    'angular',
    'angularRoute',
    'requireDomReady',
    'app'
], function (require, ng) {
    'use strict';

    require(['requireDomReady!'], function (document) {
        console.log('bootstraping');
        ng.bootstrap(document.getElementById("appContent"), ['app']);
    });
});