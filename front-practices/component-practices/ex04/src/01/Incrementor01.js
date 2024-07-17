import React, { Component } from 'react';

export default class extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <button>
                    <strong>
                        {'+'}
                    </strong>
                </button>
                {' '}
                <span>
                    {this.props.begin}
                </span>
            </div>
        );
    }
}