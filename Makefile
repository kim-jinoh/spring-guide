.PHONY: start prod dev clean build test stop

start:
	# For in-container use: run bootRun locally with --no-daemon
	./gradlew --no-daemon bootRun

prod:
	./gradlew --no-daemon bootRun --args='--spring.profiles.active=prod'

dev:
	./gradlew clean bootRun --args='--spring.profiles.active=dev'

clean:
	./gradlew clean

build:
	./gradlew clean build

test:
	./gradlew test

stop:
	# For in-container use: stop gradle daemon if any
	./gradlew --stop || true