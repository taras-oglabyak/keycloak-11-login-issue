FROM jboss/keycloak:11.0.0

ADD config /config
COPY ./keycloak-config/standalone.xml /opt/jboss/keycloak/standalone/configuration/standalone.xml
COPY ./keycloak-config/standalone-ha.xml /opt/jboss/keycloak/standalone/configuration/standalone-ha.xml

CMD ["-b", "0.0.0.0", "-Dkeycloak.migration.action=import", "-Dkeycloak.migration.provider=dir", "-Dkeycloak.migration.dir=/config/", "-Dkeycloak.migration.strategy=IGNORE_EXISTING"]

