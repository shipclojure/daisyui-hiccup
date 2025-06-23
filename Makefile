node_modules:
npm install

tailwind: node_modules
npx @tailwindcss/cli -i resources/styles/app.css -o resources/public/assets/css/compiled.css --watch

clean:
rm -fr target resources/public/js dev-resources/public/js

test:
LOG_LEVEL=warn clojure -M:dev:test -m kaocha.runner

autotest:
LOG_LEVEL=warn clojure -M:dev:test -m kaocha.runner --watch

.PHONY: tailwind clean deploy test autotest
