.PHONY: start stop restart status run

start:
	./gradlew bootRun

stop:
	./gradlew --stop