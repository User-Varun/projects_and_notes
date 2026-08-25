STEP :- 1 (make .eslintrc.json with this data )

```json
{
"extends": ["airbnb", "prettier", "plugin:node/recommended"],
"plugins": ["prettier"],
"rules": {
"prettier/prettier": ["error", { "endOfLine": "auto" }],
"spaced-comment": "off",
"no-console": "warn",
"consistent-return": "off",
"func-names": "off",
"object-shorthand": "off",
"no-process-exit": "off",
"no-param-reassign": "off",
"no-return-await": "off",
"no-underscore-dangle": "off",
"class-methods-use-this": "off",
"prefer-destructuring": ["error", { "object": true, "array": false }],
"no-unused-vars": ["error", { "argsIgnorePattern": "req|res|next|val" }]
}
}

```

STEP :- 2 add this data to package.json file in depencies object

```json
"eslint": "^8.57.1",
"eslint-config-airbnb": "^19.0.4",
"eslint-config-prettier": "^10.0.1",
"eslint-plugin-import": "^2.31.0",
"eslint-plugin-jsx-a11y": "^6.10.2",
"eslint-plugin-node": "^11.1.0",
"eslint-plugin-prettier": "^5.2.3",
"eslint-plugin-react": "^7.37.4",
"validator": "^13.12.0",
"prettier": "^3.5.0"
```

  
STEP :- 3 run npm install to install currently non installed stuff