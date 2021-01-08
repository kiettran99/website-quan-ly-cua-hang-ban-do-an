import React from 'react'
import PropTypes from 'prop-types'
import { getColor } from '@coreui/utils'
import { CChart } from '@coreui/react-chartjs'

const ChartBarRevenue = (props) => {

    const { ...attributes } = props;

    const bar = {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
        datasets: [
            {
                label: 'My First dataset',
                backgroundColor: 'rgba(255,99,132,0.2)',
                borderColor: 'rgba(255,99,132,1)',
                borderWidth: 1,
                hoverBackgroundColor: 'rgba(255,99,132,0.4)',
                hoverBorderColor: 'rgba(255,99,132,1)',
                data: [65, 59, 80, 81, 56, 55, 40],
            },
        ],
    };

    const options = {
        // tooltips: {
        //   enabled: false,
        //   custom: customTooltips
        // },
        maintainAspectRatio: false
    }

    return (
        <div className="chart-wrapper">
            <CChart type="bar"
                {...attributes}
                datasets={bar.datasets} options={options} labels="months" />
        </div>
    );
};

export default ChartBarRevenue;