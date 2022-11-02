# 個人アドカレ

[advent.dekiru.techでお試しあれ！](https://advent.dekiru.tech)

アドカレにやりたいことを予告するのはローマンある！でも... 何ヶ所のカレンダーにも参加すると、どこへいつ何が投稿予定だったのか忘れる。それとも公式のアドカレ作るまではないけど、自身へのチャレンジとして、自分だけのアドカレをやってみたい。

そういうニーズに答えるための個人アドカレだ。

[![image](https://user-images.githubusercontent.com/6322484/199551614-26370287-bfaf-4b5f-9393-cc132b8b0b5c.png)](https://advent.dekiru.tech)

## 技術スタック

* [ClojureScript](https://clojurescript.org/) ([shadow-cljs](https://github.com/thheller/shadow-cljs))
* [re-frame](https://day8.github.io/re-frame/) (React)
* [shadow-css](https://github.com/thheller/shadow-css), [Tabler Icons](https://tabler-icons.io/)
* Kubernetes, Github

## 動かすとき

### ローカル

`yarn dev` してから `localhost:8280` で確認可能。

### Docker

Githubの[Packagesに公開されている](https://github.com/valerauko/personal-advent/pkgs/container/personal-advent)ので動かしたい場合はどうぞご自由に。

自前でビルドしたい場合は[Dockerfile](Dockerfile)と[ビルドのAction](.github/workflows/release.yaml)をご参照ください。

### Kubernetes

マニフェストも公開しているので、自分のクラスターに上げたい場合は[そのマニフェスト](manifests)を参考に実装するか、kustomizeの[remote base](https://blog.yukirii.dev/use-external-git-repository-as-base-in-kustomize/)としても使えます。
