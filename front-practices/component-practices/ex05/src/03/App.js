import React, { Component } from 'react';
import './assets/scss/App.scss';
import Clock from './Clock';

export default class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            date: new Date(), // 현재 시간으로 초기화
            tick : 0
        };
        this.cron = null;
    }

    componentDidMount() {
        this.cron = setInterval(() => {
            

            // 이전의 프로퍼티를 유지하면서 프로퍼티를 변경 
            this.setState(prevState => ({
                ...prevState, // 이전 state를 그대로 복사
                date: new Date(), // date 프로퍼티만 업데이트
                tick: this.state.tick + 1
            }));

            

        }, 1000);
    }

    componentWillUnmount() {
    
        clearInterval(this.cron);
    }
    
    render() {

        const { date } = this.state;
        let hours = date.getHours();
        const minutes = date.getMinutes().toString().padStart(2, '0');
        const seconds = date.getSeconds().toString().padStart(2, '0');
        const meridiem = hours >= 12 ? 'pm' : 'am';

        if (hours > 12) {
            hours -= 12;
        } else if (hours === 0) {
            hours = 12; 
        }
        hours = hours.toString().padStart(2, '0');

        return (
            <div className='clock-display'>
                <Clock
                    title={`ex05: Clock Component tick:${this.state.tick}`}
                    hours={hours}
                    minutes={minutes}
                    seconds={seconds}
                    meridiem={meridiem} />
            </div>
        );
    }
}
