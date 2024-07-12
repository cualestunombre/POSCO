import React from 'react';
import ReactDOM from 'react-dom/client';
import {App} from './App.js';
import {title,grocery_list} from "./assets/scss/App.scss";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

