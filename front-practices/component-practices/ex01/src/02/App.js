import React, { Component } from 'react';
import { GroceryItem } from './GroceryItem';
import Style from '../../public/styles.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            newItem: { name: '', price: '' }
        };
    }

    addItem = () => {
        const { items, newItem } = this.state;
        if (newItem.name.trim() && newItem.price) {
            this.setState({
                items: [...items, newItem],
                newItem: { name: '', price: '' }
            });
        }
    };
    
    deleteItem = (name) => {
        this.setState({
            items: this.state.items.filter(item => item.name !== name)
        });
    };

    handleNameChange = (e) => {
        this.setState({
            newItem: { ...this.state.newItem, name: e.target.value }
        });
    };

    handlePriceChange = (e) => {
        this.setState({
            newItem: { ...this.state.newItem, price: Number(e.target.value) }
        });
    };

    render() {
        const { items, newItem } = this.state;

        return (
            <>
                <h1 className="title">Grocery List</h1>
                <div className="input-container">
                    <input
                        type="text"
                        placeholder="Item Name"
                        value={newItem.name}
                        onChange={this.handleNameChange}
                    />
                    <input
                        type="number"
                        placeholder="Price"
                        value={newItem.price}
                        onChange={this.handlePriceChange}
                    />
                    <button onClick={this.addItem}>Add Item</button>
                </div>
                <ol className="grocery-list">
                    {items.map((e, index) => (
                        <GroceryItem key={index} item={e} onDelete={this.deleteItem} />
                    ))}
                </ol>
            </>
        );
    }
}

export default App;
