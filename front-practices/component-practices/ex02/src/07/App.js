import React, { useState } from 'react';
import { GroceryItem } from './GroceryItem';
import {title,grocery_list} from "./assets/scss/App.scss";


export function App() {

    const [items, setItems] = useState([]);
    const [newItem, setNewItem] = useState({ name: '', price: '' });
    console.log(root);
    const addItem = () => {
        if (newItem.name.trim() && newItem.price) {
            setItems([...items, newItem]);
            setNewItem({ name: '', price: '' });
        }
    };

    const deleteItem = (name) => {
        setItems(items.filter(item => item.name !== name));
    };

    return (
        <>
            <h1 className={title}>Grocery List</h1>
            <div className='input_container'>
                <input
                    type="text"
                    placeholder="Item Name"
                    value={newItem.name}
                    onChange={(e) => setNewItem({ ...newItem, name: e.target.value })}
                />
                <input
                    type="number"
                    placeholder="Price"
                    value={newItem.price}
                    onChange={(e) => setNewItem({ ...newItem, price: Number(e.target.value) })}
                />
                <button onClick={addItem}>Add Item</button>
            </div>
            <ol className={grocery_list}>
                {items.map((e, index) => (
                    <GroceryItem key={index} item={e} onDelete={deleteItem} />
                ))}
                
                
                
                
            </ol>
        </>
    );
}
