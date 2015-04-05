require.config({

    baseUrl: '/js/admin/',

    paths: {
        'angular': '/js/libs/angular',
        'angularRoute': '/js/libs/angularRoute',
        'angularCookies': '/js/libs/angularCookies',
        'angularResource': '/js/libs/angularResource',
        'angularFileUpload': '/js/libs/angular-file-upload',
        'angularBootstrap': '/js/libs/angularBootstrap',
        'requireDomReady': '/js/libs/requireDomReady',
        'text': '/js/libs/requireText',
        'general': '/js/general'
    },

    shim: {
        'angular': {
            exports: 'angular'
        }
    },

    deps: ['./bootstrap']
});