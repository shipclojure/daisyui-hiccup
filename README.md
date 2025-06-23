# Replicant DaisyUI

A comprehensive ClojureScript component library providing Replicant wrapper components around DaisyUI CSS framework. This library provides accessible component wrappers over daisyui css classes

## Examples

```clojure
(ns example
  (:require
   [daisyui.core :as ui]))

[::ui/button {::ui/color ::ui/primary}
    "Hello world"
    [::ui/badge "+99 messages"]
    
[::ui/dropdown {::ui/alignment ::ui/end}
  [::ui/dropdown-trigger.btn.btn-ghost.rounded-field "Dropdown"]
  [::ui/dropdown-menu.mt-4.bg-base-200
    [::ui/dropdown-item [:a "Item 1"]]
    [::ui/dropdown-item [:a "Item 2"]]]]
```

## Pre-reqs 

1. Tailwind 4 & daisyUI 5 configured in your project

## Quick Start

1. Add to deps.edn
```
com.shipclojure/replicant-daisyui {:git/url "https://github.com/shipclojure/daisyui-hiccup"
                                   :git/sha "d848d7d233573754998fde9a157f723af2f47128"}

```

2. Tell tailwind about `replicant-daisyui` sources for CSS JIT compiler 

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
