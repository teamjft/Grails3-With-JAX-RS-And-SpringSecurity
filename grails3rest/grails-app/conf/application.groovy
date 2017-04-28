

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.grails3rest.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.grails3rest.security.UserRole'
grails.plugin.springsecurity.authority.className = 'com.grails3rest.security.Role'

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
/*	[pattern: '/',               access: ['permitAll']],*/
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],

	[pattern: '/**/favicon.ico', access: ['permitAll']],
	[pattern: '/api/**', access: ['IS_AUTHENTICATED_FULLY']],
[pattern: '/api/employees', access: ['ROLE_USER']],
[pattern: '/api/test', access: ['ROLE_ADMIN']],



[pattern: '/**', access: ['IS_AUTHENTICATED_FULLY']],
]


grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS'],
	//[pattern:'/api/**', filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,restTokenValidationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter'
	[pattern: '/api/test', filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter'],
[pattern: '/api/employees', filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter']]


grails.plugin.springsecurity.rest.login.active = true
grails.plugin.springsecurity.rest.login.endpointUrl = '/api/login'
grails.plugin.springsecurity.rest.login.failureStatusCode = 401
grails.plugin.springsecurity.rest.logout.endpointUrl = '/api/logout'
grails.plugin.springsecurity.rest.token.validation.useBearerToken = true
grails.plugin.springsecurity.rest.token.validation.headerName = 'X-Auth-Token'
grails.plugin.springsecurity.rest.login.usernamePropertyName = 'username'
grails.plugin.springsecurity.rest.login.passwordPropertyName = 'password'
grails.plugin.springsecurity.rest.token.generation.useSecureRandom = true
grails.plugin.springsecurity.rest.token.generation.useUUID = false

