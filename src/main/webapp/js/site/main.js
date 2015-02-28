require.config({

    baseUrl: '/js/site/',

    paths: {
        'angular': '/js/libs/angular',
        'angularRoute': '/js/libs/angularRoute',
        'angularCookies': '/js/libs/angularCookies',
        'angularResource': '/js/libs/angularResource',
        'angularFileUpload': '/js/libs/angular-file-upload',
        'requireDomReady': '/js/libs/requireDomReady',
        'text': '/js/libs/requireText'
    },

    shim: {
        'angular': {
            exports: 'angular'
        }
    },

    deps: ['./bootstrap']
});