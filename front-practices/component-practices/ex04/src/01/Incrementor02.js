import React from 'react';

export default function ({begin, step}) {
    return (
        <div>
            <button>
                <strong>
                    {'+'}
                </strong>
            </button>
            {' '}
            <span>
                {begin}
            </span>
        </div>
    );
}