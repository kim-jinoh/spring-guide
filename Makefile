.PHONY: start stop restart status run

start:
	# For in-container use: run bootRun locally with --no-daemon
	./gradlew --no-daemon bootRun

stop:
	# For in-container use: stop gradle daemon if any
	./gradlew --stop || true