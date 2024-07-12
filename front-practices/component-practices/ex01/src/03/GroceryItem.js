import React, { useState } from 'react';

export const GroceryItem = ({ item:{name,price}, onDelete }) => (
    <li key={name}>
        <strong>{name}</strong>
        <span>{price}</span>
        <button onClick={() => onDelete(name)}>Delete</button>
    </li>
);
