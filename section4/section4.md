# Section 4

## Lazy Initalization

Default initialization for Spring Beans : Eager
Eager initialization is recommended:
- Errors in the configuration are discovered immediately at application startup
Configure beans to be lazily initialized using Lazy annotation:
- NOT recommended (AND) Not frequently used
Lazy annotation:
- Can be used almost everywhere @Component and @Bean are used
- Lazy-resolution proxy will be injected instead of actual dependency
-Can be used on Configuration (@Configuration) class:
 All @Bean methods within the @Configuration will be lazily initialized