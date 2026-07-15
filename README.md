# 🔐 MCC Security Service

**Microservicio de Seguridad para Arquitectura de Microservicios Bancaria**

El presente repositorio forma parte de una arquitectura de microservicios para un sistema bancario, compuesta por 6 servicios independientes. El **Security Service** implementa **OAuth2** para brindar seguridad centralizada y control de acceso en toda la plataforma.

## 📋 Descripción

Este microservicio cumple la función de:

- ✅ Implementar autenticación y autorización mediante **OAuth2**
- ✅ Proporcionar control de acceso integrado en el **Gateway Service**
- ✅ Mantener total control sobre los demás microservicios
- ✅ Validar credenciales y tokens de usuarios
- ✅ Gestionar permisos y roles de acceso

## 🏗️ Arquitectura del Sistema

```
┌─────────────────────────────────────────────────────────────┐
│                    MICROSERVICIOS BANCARIOS                  │
└─────────────────────────────────────────────────────────────┘
                              │
                    ┌─────────────────────┐
                    │  MCC Gateway Service │
                    │   (API Gateway)      │
                    └─────────────────────┘
                         ▲   ▲   ▲
        ┌────────────────┼───┼───┼───────────────┐
        │                │   │   │               │
   ┌────▼──────┐    ┌────▼─┐ │ ┌─▼─────────────┐│
   │  Security ├───►│Account├─┼─┤   Customer   ││
   │  Service  │    │Service│ │ └───────────────┘│
   └───────────┘    └───────┘ │                  │
                               │ ┌─────────────┐ │
                               └─┤   Credit &  │ │
                                 │ Disbursement│ │
                                 └─────────────┘ │
                                 ┌──────────────┐│
                                 │ Notification ││
                                 └──────────────┘│
                                                 │
```

## 🔧 Tecnologías

- **Lenguaje:** Java (97.7%)
- **Containerización:** Docker (2.3%)
- **Seguridad:** OAuth2
- **Orquestación:** Kubernetes

## 🚀 Inicio Rápido

### Requisitos Previos

- Java 11 o superior
- Docker
- Maven
- Kubernetes (opcional)

### Instalación Local

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/victordaniel123rt-lang/mcc-security-service.git
   cd mcc-security-service
   ```

2. **Compilar el proyecto**
   ```bash
   mvn clean package
   ```

3. **Ejecutar con Docker**
   ```bash
   docker build -t mcc-security-service .
   docker run -p 8080:8080 mcc-security-service
   ```

4. **Desplegar en Kubernetes**
   ```bash
   kubectl apply -f k8s/
   ```

## 📡 Endpoints Principales

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/auth/login` | Autenticar usuario |
| `POST` | `/auth/refresh` | Refrescar token OAuth2 |
| `GET` | `/auth/validate` | Validar token activo |
| `POST` | `/auth/logout` | Cerrar sesión |

## 🔐 Flujo de Autenticación OAuth2

1. El cliente envía credenciales al **Security Service**
2. El servicio valida las credenciales y genera un token JWT
3. El token se utiliza en el **Gateway Service** para autorizar peticiones
4. El **Gateway** actúa como intermediario verificando el token con **Security**
5. Las peticiones autorizadas se enrutan a los microservicios correspondientes

## 📁 Estructura del Proyecto

```
mcc-security-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/mcc/security/
│   │   │       ├── config/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       └── SecurityApplication.java
│   │   └── resources/
│   │       └── application.yml
│   └── test/
├── Dockerfile
├── pom.xml
└── README.md
```

## 🔗 Repositorios Relacionados

- [MCC Gateway Service](https://github.com/victordaniel123rt-lang/mcc-gateway-service)
- [MCC Account Service](https://github.com/victordaniel123rt-lang/mcc-account-service)
- [MCC Customer Service](https://github.com/victordaniel123rt-lang/mcc-customer-service)
- [MCC Credit Disbursement Service](https://github.com/victordaniel123rt-lang/mcc-credit-disbursement-service)
- [MCC Notification Service](https://github.com/victordaniel123rt-lang/mcc-notification-service)

## 📝 Configuración

Las variables de entorno se configuran en `application.yml`:

```yaml
server:
  port: 8080

spring:
  application:
    name: mcc-security-service
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: ${OAUTH2_ISSUER_URI}
```

## 🧪 Pruebas

Ejecutar todos los tests:
```bash
mvn test
```

Ejecutar tests con cobertura:
```bash
mvn test jacoco:report
```

## 🐛 Reporte de Errores

Si encuentras un bug, abre un [issue](https://github.com/victordaniel123rt-lang/mcc-security-service/issues) con:
- Descripción clara del problema
- Pasos para reproducir
- Comportamiento esperado vs actual

## 📄 Licencia

Este proyecto está bajo licencia [MIT](LICENSE).

## 👨‍💻 Autor

**Victor Daniel**

---

⭐ Si este proyecto te fue útil, considera darle una estrella
