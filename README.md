# Replicant DaisyUI

A comprehensive ClojureScript component library providing Replicant wrapper components around DaisyUI CSS framework. This library provides accessible component wrappers over daisyui css classes

### Pre-reqs 

1. Tailwind & daisyUI configured.

## Quick Start

1. Add to deps.edn
```
com.shipclojure/replicant-daisyui {:git/url "https://github.com/shipclojure/daisyui-hiccup"
                                   :git/sha "d848d7d233573754998fde9a157f723af2f47128"}

```

2. Tell tailwind about `replicant-daisyui` sources for CSS JIT compoler 

In your `main.css` (or whatever name you use for the tailwind config file)
```css
@import "tailwindcss";
@plugin "daisyui";

/* If downloading as a gitlib */
@source "../relative/path/to/home/.gitlibs/libs/com.shipclojure/replicant-daisyui/{commit-sha}/src";
```

> Note: This is very clunky but required if you want the JIT compiler to pick up classes needed


## Portfolio examples

There are portfolio examples for all of the implemented components. Steps to view portfolio components: 

```sh
# 1. Clone the repo

cd replicant-daisyui

npm i # install npm deps

npm run shadow:watch # watch portfolio

# Visit localhost:8080 to see the examples
```
