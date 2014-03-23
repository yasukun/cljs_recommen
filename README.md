cljs_recommen
=============

A Leiningen 2.0 template for ClojureScript development.

## Usage

```bash
lein instal
cd foo
lein new cljs-recommen hoge
tree hoge
hoge/
├── project.clj
├── public
│   ├── css
│   │   └── page.css
│   ├── imgs
│   └── js
└── src
    ├── clj
    │   └── hoge
    │       ├── core.clj
    │       ├── handlers
    │       │   ├── api.clj
    │       │   └── app.clj
    │       └── routes.clj
    └── cljs
        └── hoge
            └── core.cljs

10 directories, 7 files
```