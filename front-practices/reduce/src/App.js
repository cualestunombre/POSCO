import { useReducer } from 'react';
import Display from './Display';

const reducer = (state, action) => {
  switch (action.type) {
    case 'INCREASE':
      return {...state,count:state.count+1}
    case 'DECREASE':
      return {...state,count:state.count-1}
    case 'ON':
      return {...state, on:true}
    case 'OFF':
      return {...state, on:false}
  }
  throw new Error('[ERROR] unknown action type');
};

export default function App() {
  const [state, dispatch] = useReducer(reducer, {count:0, on:true});

  return (
    <>

      { state.on && <Display state={state}/>}
      <button
        onClick={
          ()=>{
            dispatch({type: "ON"})
          }
        }
      >
        On Button
      </button>
      <button
        onClick={
          ()=>{
            dispatch({type: "OFF"})
          }
        }
      >
        Off Button
      </button>
      <button
        onClick={() => {
          dispatch({ type: 'INCREASE' });
        }}
      >
        Increase Counter
      </button>
      <button
        onClick={() => {
          dispatch({ type: 'DECREASE' });
        }}
      >
        Decrease Counter
      </button>
    </>
  );
}