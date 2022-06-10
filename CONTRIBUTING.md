
## Team Workflow

- Follow the [Trunk Based Development](https://www.atlassian.com/br/continuous-delivery/continuous-integration/trunk-based-development).


## Code Style Changes

To propose a new rule or a code style change, please:

1. Open a pull request with commits and checks passed
2. Request the review for the change for teammates
3. Being approved by 50% of the teammates:
   1. Configure the rule properly;
   2. Apply the rule on the whole codebase on the project;
   3. And the PR follows the regular Pull Request flow; YAY!


## Commit Types

As configured on [`commitlint`](https://commitlint.js.org/#/), it must be one of the following:

- **feat**: A new feature
- **fix**: A bug fix
- **docs**: Documentation only changes
- **style**: Changes that do not affect the meaning of the code _(white-space, formatting, missing semi-colons, etc)_
- **ref**: A code change that neither fixes a bug nor adds a feature
- **test**: Adding missing tests or correcting existing tests
- **revert**: A commit that reverts a previous commit
- **chore**: Changes to the build process or auxiliary tools and libraries such as documentation generation
- **ci**: Changes to our CI configuration files and scripts _(example scopes: Circle, BrowserStack, SauceLabs)_
- **perf**: A code change that improves performance
- **git**: Changes on git files, such as [`.gitignore`](https://git-scm.com/docs/gitignore)


## Coding Best Practices

- Write your code in [TypeScript](typescriptlang.org).
- Configure [ESLint](https://eslint.org/) on [your](https://marketplace.visualstudio.com/items?itemName=dbaeumer.vscode-eslint) [code](https://github.com/leafgarland/typescript-vim) [editor](https://marketplace.visualstudio.com/items?itemName=eg2.tslint).
- Use [Yarn](http://yarnpkg.com) to manage dependencies.
- Use English for coding, commenting and committing.
- Write [readable](https://youtu.be/56mETnrByBM) and [S.O.L.I.D.](https://scotch.io/bar-talk/s-o-l-i-d-the-first-five-principles-of-object-oriented-design) code.


## Coding Style

- Follow the [General Coding Guidelines](https://github.com/Microsoft/TypeScript/wiki/Coding-guidelines#names),
- Follow the [General Naming Guidelines](https://angular.io/guide/styleguide#general-naming-guidelines)
- Follow the [Angular Style Guide](https://angular.io/guide/styleguide) - as much as possible.


## Java Style
- Follow the [Modern Java Practices](https://github.com/binkley/modern-java-practices)