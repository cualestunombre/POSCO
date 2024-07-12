import React, { useState } from 'react';

export const GroceryItem = ({ item, onDelete }) => (
    <li key={item.name}>
        <strong>{item.name}</strong>
        <span>{item.price}</span>
        <button onClick={() => onDelete(item.name)}>Delete</button>
    </li>
);
