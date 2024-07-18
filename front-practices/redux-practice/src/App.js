import logo from './logo.svg';
import './App.css';
import { configureStore } from '@reduxjs/toolkit'
import { Provider } from 'react-redux'
import store from './store.js'
import Counter from './counter/Counter'



function App() {
  return (  
    <div>
        <Provider store={store}><Counter></Counter></Provider>
    </div>
  );
}

export default App;
