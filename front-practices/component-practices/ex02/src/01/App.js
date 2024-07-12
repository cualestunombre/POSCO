import React from 'react';

function App() {
    const h1Style = {
        width:200,
        color:'red'
    };

    return (
        <div style={h1Style} id={'App'}>
            <h1>inline styling</h1>
        </div>
    );
}

export default App;